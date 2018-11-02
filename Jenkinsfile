
library identifier: 'playground_ci_jenkins@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'git@github.com:benatimbus/playground_ci_jenkins.git',
     credentialsId: '73142bae-9eea-4a1f-a916-23e8db523085']
)

import ci.stage.*

pipeline {
    agent any

    stages {

        Build(true, true, true, true)

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
