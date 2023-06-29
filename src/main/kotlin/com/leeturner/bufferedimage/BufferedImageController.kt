package com.leeturner.bufferedimage

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/buffered-image")
class BufferedImageController {

  // create a controller method that will return a buffered image
  @Get
  @Produces(MediaType.IMAGE_JPEG) // Adjust the media type based on the image format
  fun loadImage(): ByteArray? {
    val imageStream =
        javaClass.getResourceAsStream("/images/astronaut.jpeg")
            ?: error("Image could not be found") // Replace with your image path
    return imageStream.readBytes()
  }
}
