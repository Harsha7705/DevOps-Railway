pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java21'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn -B test'
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
