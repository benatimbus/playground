
pipeline {
    agent any

    triggers {
        pollSCM('*/5 * * * *')
    }

    stages {
        stage('Build & Unit Test') {
            steps {
                bat 'gradlew clean build jacocoTestReport'
                jacoco(execPattern: '**/*.exec')
            }
        }
        stage('SonarQube') {
            steps {
                echo 'SonarQube....'
            }
        }
        stage('Integration Tests') {
            steps {
                echo 'Integration Tests....'
            }
        }
        stage('Docker Image') {
            steps {
                echo 'Docker Image....'
            }
        }
    }
}