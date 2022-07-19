# WaterMyPlantsKotlin
A Jetpack Compose example using new experimental animations. 

Do you want to use declarative UI like SwiftUI or Flutter, but even more readable and in Kotlin? Well now you can. That's what Jetpack Compose is! 

With Accompanist-Navigation-Animation you can add navigation and box transitions easily. This project uses navigation transitions between the dashboard and
splash screen, and Animated Visibility transitions to change the dashboard content when you change the bottom menu item.  

# Video
 [video](https://github.com/edunnett/WaterMyPlantsKotlin/blob/main/screenshots/Screen%20Recording%202022-07-19%20at%2011.56.36%20AM.mov?raw=true) 

# Screenshots

![Screenshot 1](/screenshots/Screenshot_1658237133.png?raw=true=300)
![Screenshot 2](/screenshots/Screenshot_1658237105.png?raw=true=300)
![Screenshot 3](/screenshots/Screenshot_1658237101.png?raw=true=300)
=
# Stack

- [Jetpack](https://developer.android.com/jetpack)
  
  -   [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
    - [AndroidX](https://developer.android.com/jetpack/androidx) -The androidx namespace comprises the Android Jetpack libraries. Like the Support Library, libraries in the androidx namespace ship separately from the Android platform and provide backward compatibility across Android releases.

- [Protobuf](https://github.com/protocolbuffers/protobuf) - Protocol Buffers (a.k.a., protobuf) are Google's language-neutral, platform-neutral, extensible mechanism for serializing structured data.

- [ByteBeats Compose Charts](https://github.com/bytebeats/compose-charts) - Simple Jetpack Compose Charts for multi-platform. Including Android, Web, Desktop.
   
- [Compose-Accompanist](https://google.github.io/accompanist/) - Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.
  -  [Navigation Animation](https://google.github.io/accompanist/navigation-animation/) A library which provides Compose Animation support for Jetpack Navigation Compose.

- [Hilt](https://dagger.dev/hilt/) - For Dependency Injection.


# Generating Data Class From Protobuf lite

Proto provides code generation for interoperable RPC and message opjects that can be passed through gRPC or used directly in your app.

Here, I've defined my plant prototype and used the object type generated to provide a simple list of houseplant objects as a sequence in data/HouseplantData.kt. (The idea is to interface with gRPC data in the next release.)

	syntax = "proto3";
	option java_package = "com.example.watermyplants"; //important. This will be the namespace you use to reference the messages in Kotlin code
	option java_multiple_files = true;
	message Houseplant
	{
    	string name = 1;
    	string status = 2;
    	string imageUrl = 3;
	}
	message Houseplants
	{
    	repeated Houseplant houseplant = 1;
	}
	
	



# License and Usage

MIT License

Feel free to take a look and learn from this code. I hope it helps you in your next project!
