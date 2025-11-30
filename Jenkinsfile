pipeline {
    agent any

    tools {
        // Make sure these names match the ones configured in Jenkins under "Global Tool Configuration"
        jdk 'Java21'
        maven 'Maven3'
    }

    environment {
        // Optional: Add JAVA_HOME if needed
        JAVA_HOME = "${tool 'Java21'}"
        PATH = "${tool 'Maven3'}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Harsha7705/Railway-System.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and package the Maven project
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Run') {
            steps {
                // Run the generated jar file
                bat 'java -jar target/railway-reservation-1.0.0.jar'
            }
        }
    }

    post {
        success {
            echo '✅ Build, tests, and run succeeded!'
        }
        failure {
            echo '❌ Build, tests, or run failed!'
        }
    }
}
