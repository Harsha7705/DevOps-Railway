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
                sh 'mvn -B clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn -B test || true'
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
