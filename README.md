# Archtest

The purpose of this project is to help me to understand how some of the Android libraries are working and experiment with different ways of implementing them. This project is not designed as an example or for education purposes. However, feel free to use it as an example or contact me if you need any explanation or details -> [Eduards Denisjonoks][0]

# Free APIs used in this project
- https://thecatapi.com/ <- Cat images 
- http://www.icndb.com/api/ <- Chuck Norris jokes 
- https://swapi.co/ <- Star Wars data

# Librarises used in thsi project 
- Firbase 
  - [Crashlytics][1] - is used in combination of Timber to log any crashes or exceptions 
  - [Performance][2] - just to see what sort of data I can get from this tool 
  - [Analytics][3] - just to see what sort of data I can get from this tool 
- [Timber][4] - replacement for default Logger 
- [Paging library][5] - testing implementation of static data source and data source with dynamic parameters like search query 
- [Navigation][6]
  - Testing in-app navigation 
  - Testing bottom navigation support 
  - Testing toolbar support 
  - Testing Safe args 
- [Coroutines][7] - testing implementation with the combination of retrofit and view models  
- [Koin][8] - testing implementation as alternative to Dagger 2 
- [Retrofit][9] - almost standard libary for API handlign 
- [Picasso][10] - simple and powerful image managment library  
- [ConstraintLayout][11] - my favorite layout 
  - [MotionLayout][12] - experimenting with it, mostly used to simplify collapsing toolbar implementation 


[0]: https://www.linkedin.com/in/eduardsdenisjonoks/
[1]: https://firebase.google.com/products/crashlytics/
[2]: https://firebase.google.com/products/performance/
[3]: https://firebase.google.com/products/analytics/
[4]: https://github.com/JakeWharton/timber
[5]: https://developer.android.com/topic/libraries/architecture/paging
[6]: https://developer.android.com/guide/navigation
[7]: https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html
[8]: https://insert-koin.io/
[9]: https://square.github.io/retrofit/
[10]: https://square.github.io/picasso/
[11]: https://developer.android.com/training/constraint-layout
[12]: https://developer.android.com/training/constraint-layout/motionlayout
