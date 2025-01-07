def build() {
    wsdir = pwd()
    stage('Preparation' {
        sh "echo ${wsdir}"
    })
    stage('Build') {
        sh "echo Build"
    }
    stage('Test') {
        sh "echo Test"
    }
}

timeout(time: 12, unit: 'HOURS') {
    timestamps() {
        node('linux') { //'ub-build-itest') {
            build()
        }
    }
}