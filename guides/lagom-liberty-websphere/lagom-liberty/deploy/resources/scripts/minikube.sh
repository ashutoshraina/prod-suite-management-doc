#!/usr/bin/env bash

(minikube delete || true) &>/dev/null && minikube start --memory 2048 && eval $(minikube docker-env)

cd guides/lagom-liberty-websphere/lagom-liberty

sbt clean docker:publishLocal && mvn -f liberty/pom.xml clean package install && docker build -t liberty-app liberty

kubectl create -f deploy/resources/lagom && kubectl create -f deploy/resources/nginx && kubectl create -f deploy/resources/liberty

echo "Endpoint Urls: $(minikube service --url nginx-ingress | head -n 1)"
echo "Kubernetes Dashboard: $(minikube dashboard --url)"

cd ../../..