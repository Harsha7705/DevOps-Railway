pipeline {
    agent any

    tools {
        maven 'Maven3'      // Jenkins → Global Tools → Maven installation name
        jdk 'Java21'  
        git 'GitDefault' // Jenkins → JDK installation name
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
                sh 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Build & Tests passed. Pipeline green.'
        }
        failure {
            echo 'Pipeline failed. Fix the issues and re-run.'
        }
    }
}
