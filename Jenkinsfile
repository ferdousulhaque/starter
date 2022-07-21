pipeline {
    agent any
    triggers {
        pollSCM '0 2 * * *'
    }
    stages {
        stage('Build'){
            steps {
                sh './gradlew assemble'
            }
        }
    }

}