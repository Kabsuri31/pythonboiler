## Python_Boilerplate ##

## Tagwords ##
Python

## Overview ##
The Python automation framework is a technology specific reusable blueprint which helps to kickstart DevOps journey. It enables and automates the delivery pipeline for any Python-based application to streamline the entire process right from integration, delivery, testing, till deployment.

## Benefits ##
1.Drives rapid mobilization with ready-to-use platform for continuous integration and deployment with inbuilt security.
2.Ensures zero downtime with Blue-Green deployment, running two identical production environments.
3.Increased efficiency and cost savings with automated DevOps tools setup.
4.Mitigates risk and aids in compliance adherence with various scans.
5.Graphically represents the pipeline metrics, thus providing insights into the pipeline. 
6.Saves testing time with automated testing stages, thereby improving the team’s efficiency.
7.Faster deployment to the desired environment, eliminating the need for manual intervention.

## Tools and Tool Versions ##

# Platform Tools #
Platform-agent (v5.5-v3.0)
myWizard DevOps UI Login -Parent (8.4)
Oauth2-Proxy (7.4.0)
Keycloak-Postgres (14)
Keycloak (17.0.1) 
Platformapi (1.0.0)
PostgreSQL (1.16.0)
Nginx Ingress (v1.10.0)
Velero (1.13.0)
MkDocs (1.5.3)
K8 dashboard (2.7.0)
Cert-manager (v1.13.0)
Loki-stack (2.9.5)
Influxdb2 (2.7.5)
Kubeapps (2.9.0)

# Stage Tools #
SonarQube (10.2.1-community)
Sonar-Postgres (14)
Gunicorn (19.6.0)
Python (3.8.5)
Maven (3.8.1)
Kaniko (1.3.0)
Pytest (4.6.2)
Selenium (4.18.1)
Jmeter (5.4.3)
Gatling (3.5.1)
Trivy (0.32.1)
OWASP ZAP (2.11.1)
Lighthouse (9.6.8)
Jenkins (2.450-jdk11)
PyMongo (3.8.0)
GitLab (16.9.2)
PostgreSQL (1.16.0)
Jake (1.4.5)
Nexus (3.62.0)

# Monitoring Tools #
Grafana(10.4.1)
Prometheus(2.50.1)

## Features ##
1.Host your application on any cloud provider without any additional manual effort. The pipeline picks up the source code from the referenced repository and the CI/CD/CT pipeline gets executed automatically upon triggering the pipeline.
2.The pipeline metrics, deployments status, and builds through various environments (such as Deployment, Testing, and Production) are presented with easy to consume visuals via Grafana dashboard.
3.The security and vulnerability scans such as SAST, Secret Scan, Vulnerabilities, and Configuration scan are built as part of the CI/CD pipeline, thereby integrating security with the application development.
4.Continuous monitoring of code quality with SonarQube integrated in the CI pipeline, removes the need of manual set up and configuration.
5.Maintains quality of the application with load testing, which tests the load performance of the application every time the pipeline is triggered.
6.The build time is reduced with parallel execution of stages and multistage builds. In addition, PVCs act as cache to store the application dependencies (that are downloaded) helping to reduce the build time further.

## Pre-Requisites ##
N/A

## Pipeline Diagram ##
Yes

## Architecture Diagram ##
N/A

## Documentation ##
This automation framework can be accessed via DevXOps Platform that is provisioned through the Developer Marketplace. Once the automation framework is provisioned, the URL and the required credentials are provided via email.

## Contributors ##
suraksha.raju
akhila.r.ashwath
