import Docker

def call(String imageName) {
    /*def docker = new Docker(this)
    docker.build()
    docker.login()*/
    return new Docker(this).dockerLogin()
}