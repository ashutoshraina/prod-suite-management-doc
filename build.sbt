lazy val root = project
  .in(file("."))
  .aggregate(
    dcosMicroservices,
    k8sMicroservices,
    k8AkkaCluster,
    lagomlibertywebsphere,
    docs
  )

lazy val dcosMicroservices = project
  .in(file("guides/dcos-microservices"))
  .enablePlugins(ParadoxPlugin)

lazy val k8sMicroservices = project
  .in(file("guides/k8s-microservices"))
  .enablePlugins(ParadoxPlugin)

lazy val k8AkkaCluster = project
  .in(file("guides/k8-akka-cluster"))
  .enablePlugins(ParadoxPlugin)

lazy val lagomlibertywebsphere = project
  .in(file("guides/lagom-liberty-websphere"))
  .enablePlugins(ParadoxPlugin)

lazy val docs = project
  .in(file("docs"))
  .enablePlugins(ParadoxPlugin)

name := "prod-suite-management-doc"
