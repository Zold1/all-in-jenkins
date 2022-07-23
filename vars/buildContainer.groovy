import Docker 

def call(String imageName) {
    def docker = new Docker(this)
    docker.login()
    
}