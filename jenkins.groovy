//properties([pipelineTriggers([cron('*/5 * * * *')])])
properties([
    pipelineTriggers([
        GenericTrigger(
            causeString: 'Push to master', 
            genericVariables: [[
                defaultValue: '',
                key: 'ref', 
                regexpFilter: '', 
                value: '$.ref'
            ]], 
            printContributedVariables: true, 
            printPostContent: true, 
            regexpFilterExpression: 'master$', 
            regexpFilterText: '$ref', 
            silentResponse: true, 
            token: '4da494e53758b69e3eca3fa0dca6e189628c1f57'
        )
    ])
])

node {
    stage('stage01') 
    {
        sh"uptime"
        deleteDir()
     }
    stage("github")
    {
    http://35.223.111.195/generic-webhook-trigger/invoke?token=4da494e53758b69e3eca3fa0dca6e189628c1f57 
    //withCredentials([usernamePassword(credentialsId: '9c3062a2-17a2-4617-a332-6cff68b12cea', passwordVariable: 'password', usernameVariable: 'username')]) 
    //{sh"git clone https://$username:$password@github.com/yd77work/Ansible"
    {sh"git clone  -b master https://yd77work:4da494e53758b69e3eca3fa0dca6e189628c1f57@github.com/yd77work/Ansible"
    }
    }
    stage("stage02")
    {
        def workDir = sh(returnStdout: true, script: "pwd").trim()
        sh "cd $workDir && cd ./Ansible && ls -lh"
    }
    stage("stage03")
    {
        archiveArtifacts artifacts: "**/Ansible/ansible/*.yml", fingerprint: true
     }
}
