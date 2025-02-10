pipeline {
    agent any

    environment {
        // Укажите переменные окружения, если нужно
        DOCKER_HUB = 'your-dockerhub-username'
        APP_NAME = 'spring-boot-app'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/markovadim/cryptocurrency-watcher.git'
            }
        }

        stage('Build') {
            steps {
                sh 'gradle clean build' // Сборка проекта с помощью Maven
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test' // Запуск тестов
            }
        }

        // stage('Build Docker Image') {
        //     steps {
        //         script {
        //             docker.build("${DOCKER_HUB}/${APP_NAME}:${env.BUILD_ID}")
        //         }
        //     }
        // }

        stage('Deploy') {
            steps {
                script {
                    // Остановка и удаление старого контейнера
                    sh 'docker stop ${APP_NAME} || true'
                    sh 'docker rm ${APP_NAME} || true'

                    // Запуск нового контейнера
                    sh 'docker compose up'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
