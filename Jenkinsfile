
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
