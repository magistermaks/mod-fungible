## Fungible
This mod, with help of some mixin hacks, speeds up game and world loading
times by selectively bricking parts of the game. Do not use outside the
development environment - it will cause world corruption when upgrading 
save data. With this mod it takes about 8s to launch the game and load into
a world, compared to the average 19s to do the same on vanilla. It also silences 
the annoying auth exception that takes focus away from the game log in IDEA.

#### Included hacks:
| Name                             | Desc                                                                     | Credit                                                         |
|----------------------------------|--------------------------------------------------------------------------|----------------------------------------------------------------|
| DataBreaker 2: Electric Boogaloo | Brick DataFixerUpper                                                     | mostly made myself, by i did look at how SuperCoder7979 did it |
| Narratorn't                      | Brick the Narrator library (is it faster? idk)                           |                                                                |
| ShutAuth                         | Brick game auth (this is to prevent that annoying exception on startup)  |                                                                |
| SpawnChunksBeGone                | Skips spawn chunk loading                                                | (copied from TBPlugin)                                         |
| FadeYeet                         | Yeets resource reload fade out animation                                 |                                                                |
| ProfileUnkeyed                   | Skips message key pair request (to prevent another exception on startup) | jacg311                                                        |

#### Credits:
SuperCoder7979 (i taken a look at DataBreaker)