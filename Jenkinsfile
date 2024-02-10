pipeline {
    agent { label 'slave' }
ssas
    stages {
        stage('Checkout') {
            steps {
                // Adjust this to match your SCM configuration
                git 'https://github.com/YourRepository/YourProject.git'
            }
        }
        stage('Build') {
            steps {
                // Compile your project without running tests
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                // Wrap the test command with Xvfb to provide a virtual display
                wrap([$class: 'Xvfb']) {
                    sh 'mvn test'
                }
            }
        }
    }
    post {
        success {
            echo 'Build and tests succeeded.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
