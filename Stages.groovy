package me.werling.playground.ci

def build() {
    stage("Build"){
        bat "gradlew clean assemble"
    }
}

def test(){
    stage ("Test") {
        bat "gradlew test"
    }
}