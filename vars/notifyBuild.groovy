#!/usr/bin/env groovy

def call(String buildStatus = 'STARTED') {
// build status of null means successful
// 빌드상태가 널이면 성공을 의미한다.
buildStatus =  buildStatus ?: 'SUCCESSFUL'

// Default values
def colorName = 'RED'
def colorCode = '#FF0000'
def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
def summary = "${subject} (${env.BUILD_URL}) ${env.GIT_SHORT_COMMIT}"

// Override default values based on build status
if (buildStatus == 'STARTED') {
  color = 'YELLOW'
  colorCode = '#FFFF00'
} else if (buildStatus == 'SUCCESSFUL') {
  color = 'GREEN'
  colorCode = '#00FF00'
} else {
  color = 'RED'
  colorCode = '#FF0000'
}
slackSend (color: colorCode, message: summary)
}
