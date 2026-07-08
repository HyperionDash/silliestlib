<div align="center">
<p><img src="https://cdn.modrinth.com/data/cached_images/53dfd913e3be1485e544a6cd6c4ce1ab8ec11040.png">
<p><a href="https://www.youtube.com/@HyperionDash"><img src="https://github.com/intergrav/devins-badges/blob/v3/assets/cozy-minimal/social/youtube-plural_64h.png?raw=true"></a>&nbsp;&nbsp;&nbsp;
<a href="https://modrinth.com/user/HyperionDash"><img src="https://github.com/intergrav/devins-badges/blob/v3/assets/cozy-minimal/documentation/modrinth-gallery_64h.png?raw=true"></a>&nbsp;&nbsp;&nbsp;
<a href="https://discord.gg/5Tmsw388ah"><img src="https://github.com/intergrav/devins-badges/blob/v3/assets/cozy-minimal/social/discord-singular_64h.png?raw=true"></a>&nbsp;&nbsp;&nbsp;
<a href="https://github.com/HyperionDash"><img src="https://github.com/intergrav/devins-badges/blob/v3/assets/cozy-minimal/available/github_64h.png?raw=true"></a>

#
<p align="center">SilliestLib is a small library mod made for the Silliest SMP team, reducing re-used code and making some things easier for us :p<p>

## <p align="center">Project Info</p>

<details>
<summary>How to add SilliestLib to your projects.</summary>
<div align="left">
NOTE: the project is not currently published on modrinth, and so this example will not work at the moment, please use "implementation files()" to add the mod jar from your files to your project of the plain "implementation"

## build.gradle
We start in your build.gradle, where you add this as your repositories block.
```gradle
repositories {
    exclusiveContent {
        forRepository {
            maven {
                name = "Modrinth"
                url = "https://api.modrinth.com/maven"
            }
        }
        filter {
            includeGroup "maven.modrinth"
        }
    }
}
```
Then, in dependencies block, you add this.
```gradle
dependencies {
    // SilliestLib
    implementation "maven.modrinth:silliestlib:${project.silliestlib_version}"
}
```

## gradle.properties
In your gradle.properties, you now need to add the mod version, this changes with every update to the mod, so make sure to change it to update SilliestLib.
```properties
silliestlib_version=5C7uJjvj
```
This is technically optional and can replace "${project.silliestlib_version}" in the build.gradle instead of being here, but is cleaner to do here.

## fabric.mod.json
To make sure people can debug issues when SilliestLib is missing, remember to add the mod into the dependencies block, due to my versioning scheme not matching the semantic version format, make sure you have to version as "*" or it wont work :p
```json
"depends": {
    "silliestlib": "*"
}
```

## Your ModInitializer
Before you can start any modding, in the "onInitialize()" method of your ModInitializer you have to add one simple line.
```java
init(MOD_ID);
```
Alternatively, "MOD_ID" can be replaced with either a string of your modId or a call to where you store your modId.
</div>
</details>

for more information on how to use the mod, please go to the [wiki](https://github.com/HyperionDash/silliestlib/wiki)

## <p align="center">Before You Ask</p>
**<p align="center">Q: Can i use this project in my published modpacks?</p>**
<p align="center">A: of course, you can do this with any of my projects aslong as the download stays hosted within the modrinth ecosystem :3</p>
</div>