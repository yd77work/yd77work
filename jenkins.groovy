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
            token: '32REFERGTG544GTOGK4TO5GT'
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
    http://35.223.111.195/generic-webhook-trigger/invoke?token=32REFERGTG544GTOGK4TO5GT 
    //withCredentials([usernamePassword(credentialsId: '9c3062a2-17a2-4617-a332-6cff68b12cea', passwordVariable: 'password', usernameVariable: 'username')]) 
    //{sh"git clone https://$username:$password@github.com/yd77work/Ansible"
    {sh"git clone  -b master yd77work@github.com:/yd77work/Ansible.git"
    }
    }
    stage("stage02")
    {
        def workDir = sh(returnStdout: true, script: "pwd").trim()
        sh "cd $workDir && cd ./Ansible && ls -lh"
    }
    stage("stage03")
    {
        archiveArtifacts artifacts: "https://github.com/yd77work/Ansible/tree/master/ansible/*.yml", fingerprint: true
     }
}
