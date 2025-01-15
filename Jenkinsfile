pipeline {
    agent {
        label ''
    }
    tools {
        jdk 'JDK_21'
        maven 'Maven'
    }
    stages {
        stage('Set Up') {
            steps {
                echo "Setting up Java and Maven..."
                sh 'java -version' 
                sh 'mvn -version' 
            }
        }
        stage('Start Tomcat') {
            steps {
                echo "Checking and starting Tomcat..."
                script {
                    sh '''
                    export PATH="/opt/homebrew/bin:$PATH"
                    if ! nc -z localhost 8070; then
                        echo "Tomcat is not running. Starting Tomcat..."
                        brew services start tomcat
                        if [ $? -eq 0 ]; then
                            echo "Tomcat started successfully."
                        else
                            echo "Failed to start Tomcat. Please check the logs."
                        fi
                    else
                        echo "Tomcat is already running on port 8070."
                    fi
                    '''
                }
            }
        }
        stage('Build') {
            steps {
                echo "Building the project..."
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'mvn test'
            }
        }
        stage('Deploy to Tomcat') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying to Tomcat...'
                deploy adapters: [tomcat9(credentialsId: 'tomcat-credentials',
                                           path: '',
                                           url: 'http://localhost:8070/manager/text')],
                       contextPath: 'calc-app',
                       war: '**/target/*.war'
            }
        }
    }
}