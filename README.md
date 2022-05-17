<div id="top"></div>

[![MIT License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/jwhaubrich/Simple-Calculator">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg/340px-Casio_calculator_JS-20WK_in_201901_002.jpg" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Simple Calculator</h3>

  <p align="center">
    A simple calculator that performs basic mathematical functions: addition, subtraction, multiply, and divide.
    <br />
    <a href="https://github.com/jwhaubrich/Simple-Calculator"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    ·
    <a href="https://github.com/jwhaubrich/Simple-Calculator/issues">Report Bug</a>
    ·
    <a href="https://github.com/jwhaubrich/Simple-Calculator/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![Product Name Screen Shot][product-screenshot]](https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg/340px-Casio_calculator_JS-20WK_in_201901_002.jpg)

This project was developed to help users perform basic mathematical functions such as addition, subtraction, multiply, and divide. The functionality within the code is very basic to aid in execution of the program for the user. Upon execution of the main program the user will 
1. Select which operation to perform.
2. Enter the two numbers that they wish to use within the applicaiton.
3. Decide if they want to continue.

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Java 8: Version 1.8.0_301 ](https://java.com/en/)
* [Gradle: Version 7.4.2](https://gradle.org/)
* [Groovy: Version 3.0.9](https://groovy-lang.org/)
* [Ant: Version 1.10.11](https://ant.apache.org/)
* [JVM: Version 1.8.0_301](https://www.java.com/en/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

First, we'll need to copy this repo to your machine, then running the application by creating a jar file. Please see the instructions that follow:


### Running the Program

1. Clone the repo
   ```sh
   git clone https://github.com/jwhaubrich/Simple-Calculator.git
   ```
2. Navigate to local directory where the repo is located on your machine. In that same directory, run the following command to create jar file with Gradle.
   ```sh
   ./gradlew jar
   ```
3. Change directories to SimpleCalculator>build>libs
   ```sh
   cd build/libs
   ```
4. Run the Simple Calculator program with:
   ```sh
   java -jar SimpleCalculatorWithGradle-1.0.2.jar 
   ```

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTRIBUTING -->
## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git switch -c feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Joe Haubrich - [@joe_haubrich](https://twitter.com/joe_haubrich) - jwhaubrich@gmail.com

Project Link: [https://github.com/jwhaubrich/Simple-Calculator](https://github.com/jwhaubrich/Simple-Calculator)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
[product-screenshot]: https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Casio_calculator_JS-20WK_in_201901_002.jpg/340px-Casio_calculator_JS-20WK_in_201901_002.jpg
[license-shield]: https://camo.githubusercontent.com/111148992d0253f8d5e36b62087d48a9eabb1d7244b2b7316214f47d5c9a8781/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6c6963656e73652f6f74686e65696c647265772f426573742d524541444d452d54656d706c6174652e7376673f7374796c653d666f722d7468652d6261646765
[license-url]: https://github.com/jwhaubrich/Simple-Calculator/blob/main/LICENSE
