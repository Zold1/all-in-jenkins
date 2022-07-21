#!/usr/bin/env groovy

import containerization.Docker 

def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}