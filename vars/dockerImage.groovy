#!/usr/bin/env groovy

import Docker

def call(String imageName) {
  def docker = new Docker(this)
  docker.build(imageName)
  docker.login()
  docker.push(imageName)
}
