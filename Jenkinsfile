pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Unit Test & Coverage') {
            steps {
                echo 'Testing..'
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