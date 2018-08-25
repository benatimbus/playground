
library identifier: '', retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'git@github.com:benatimbus/playground_ci_jenkins.git',
     credentialsId: '3dc90b17-3b94-4e88-b7c7-41e1bed91bd0'
)

pipeline {
    agent any

    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        stage('Build & Unit Test') {
            steps {
                bat 'gradlew clean build jacocoTestReport'
                step( [ $class: 'JacocoPublisher' ] )
                junit "build/test-results/test/**/*.xml"
            }
        }
        stage('SonarQube') {
            steps {
                bat "gradlew sonarqube -Dsonar.host.url=http://localhost:9000 -Dsonar.login=170bb50ab9b069526a12b9e3270ef0f1aa8e53dd"
            }
        }
        stage('Integration Tests') {
            steps {
                echo 'gradlew integration_test'
            }
        }
        stage('Docker Image') {
            steps {
                echo 'Docker Image....'
            }
        }
    }
}
