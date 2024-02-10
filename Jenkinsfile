pipeline {
    agent {
        label 'slave' // Ensure this runs on your designated slave node
    }
    tools {
        // Define tools required, ensure these names match your Jenkins configuration
        maven 'Maven 3' // Name of the Maven installation in Jenkins configuration
        jdk 'JDK 17' // Name of the JDK installation in Jenkins configuration
    }
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
