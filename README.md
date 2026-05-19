# Data Structures and Algorithms

This repository contains DSA programs I've written for C, C++, Java and Kotlin.  
Enjoy.

Check out the [ROADMAP.md](ROADMAP.md) for progress and quick links to the algorithms.

## Installation

### Install dependencies

Installing the required compilers for compiling and running the programs.

```bash
sudo apt update
sudo apt install gcc g++ openjdk-21-jdk kotlin make
```

Verify installation:

```bash
gcc --version
g++ --version
java --version
kotlinc -version
```

## Cloning the repo

Once the prerequisites have been installed, clone the repo.

HTTPS:

```bash
git clone https://github.com/PCG06/dsa-stuff.git
```

SSH (recommended):

```bash
git clone git@github.com:PCG06/dsa-stuff.git
```

Programs have been separated by language, each has its own subfolder instead `src/` directory, such as `src/c`, `src/cpp`, `src/java` and `src/kotlin`.

## Compiling and Running

Compiling converts the written source code into machine code that the computer understands.  
Once a program has been compiled, we can run the output.  
Source programs are in `src/*/*`, and compiled output will be in `build/*/*` respectively.

## Using `make`

`make` will compile all programs from all sub-folders.

```bash
make
```

<!-- markdownlint-disable MD033 -->
## Using `make <file>`

To compile and run individal programs, use `make <file>`.

Some examples:

<details>
<summary>C</summary>

Compile `src/c/binary_search.c` and run its binary `build/c/binary_search`

```bash
make binary_search.c
```

</details>

<details>
<summary>C++</summary>

Compile `src/cpp/binary_search.cpp` and run its binary `build/cpp/binary_search`

```bash
make binary_search.cpp
```

</details>

<details>
<summary>Java</summary>

Compile `src/java/BinarySearch.java` and run its binary `build/java/BinarySearch.class`

```bash
make BinarySearch.c
```

</details>

<details>
<summary>Kotlin</summary>

Compile `src/kotlin/BinarySearch.kt` and run its binary `build/kotlin/BinarySearchKt.class`

```bash
make BinarySearch.kt
```

</details>

## Using `make clean`

`make clean` removes all output files by deleting the `build/` directory.

```bash
make clean
```

## Summary of Important Commands

| Command                 | Action                                          |
|-------------------------|-------------------------------------------------|
| `make`                  | Compiles all source files.                      |
| `make some_file.c`      | Compiles and runs specified C source file.      |
| `make some_file.cpp`    | Compiles and runs specified C++ source file.    |
| `make SomeFile.java`    | Compiles and runs specified Java source file.   |
| `make SomeFile.kotlin`  | Compiles and runs specified Kotlin source file. |
| `make c`                | Compiles all C source files.                    |
| `make cpp`              | Compiles all C++ source files.                  |
| `make java`             | Compiles all Java source files.                 |
| `make kotlin`           | Compiles all Kotlin source files.               |
| `make clean`            | Deletes the `build/` directory.                 |
