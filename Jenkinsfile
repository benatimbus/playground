import static me.werling.playground.ci.*

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
                bat 'gradlew integration_test'
            }
        }
        stage('Docker Image') {
            steps {
                echo 'Docker Image....'
            }
        }
    }
}
