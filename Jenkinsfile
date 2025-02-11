pipeline {
    agent any

    environment {
        GIT_REPO = 'git@github.com:markovadim/cryptocurrency-watcher.git'
        BRANCH = 'master'
        DEPLOY_SERVER = 'root@178.253.40.7'
        DEPLOY_DIR = '/var/www/cryptocurrency-watcher'
        JAR_NAME = 'cryptocurrencywatcher-0.1.jar'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${BRANCH}", credentialsId: '597d3a7b-00b2-48cc-9783-785d87a7aff3', url: "${GIT_REPO}"
            }
        }

        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build -x test'
                }
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh """
                    scp build/libs/*.jar ${DEPLOY_SERVER}:${DEPLOY_DIR}/${JAR_NAME}
                    ssh ${DEPLOY_SERVER} << EOF
                        pkill -f ${JAR_NAME} || true
                        nohup java -jar ${DEPLOY_DIR}/${JAR_NAME} > ${DEPLOY_DIR}/app.log 2>&1 &
                    EOF
                    """
                }
            }
        }
    }
}
