# Directory structure
SRC        := src
BUILD_DIR  := build
INCLUDE_DIR := include

# Source files
C_SRC    := $(wildcard $(SRC)/c/*.c)
CPP_SRC  := $(wildcard $(SRC)/cpp/*.cpp)
JAVA_SRC := $(wildcard $(SRC)/java/*.java)
KT_SRC   := $(wildcard $(SRC)/kotlin/*.kt)

# Executables and class files
C_BIN    := $(patsubst $(SRC)/c/%.c, $(BUILD_DIR)/c/%, $(C_SRC))
C_DEPS   := $(C_BIN:%=%.d)
CPP_BIN  := $(patsubst $(SRC)/cpp/%.cpp, $(BUILD_DIR)/cpp/%, $(CPP_SRC))
CPP_DEPS := $(CPP_BIN:%=%.d)
JAVA_CLASS := $(patsubst $(SRC)/java/%.java, $(BUILD_DIR)/java/%.class, $(JAVA_SRC))
KT_CLASS   := $(patsubst $(SRC)/kotlin/%.kt, $(BUILD_DIR)/kotlin/%.class, $(KT_SRC))

# Compilers and flags
CC       := gcc
CXX      := g++
JAVAC    := javac
KOTLINC  := kotlinc

CFLAGS   := -I$(INCLUDE_DIR) -Wall -Wextra -O2 -Wno-unused-result -Wno-sign-compare -Wno-format
CXXFLAGS := -I$(INCLUDE_DIR) -Wall -Wextra -O2 -Wno-unused-result -Wno-sign-compare -Wno-format

# Default target: compile everything
all: $(C_BIN) $(CPP_BIN) $(JAVA_CLASS) $(KT_CLASS)
	@echo "All source files compiled!"

# Create necessary directories (real targets, not phony)
$(BUILD_DIR)/c $(BUILD_DIR)/cpp $(BUILD_DIR)/java $(BUILD_DIR)/kotlin:
	mkdir -p $@

%.d: ;

# Auto-generated header dependencies
-include $(C_DEPS)
-include $(CPP_DEPS)

# C compilation
$(BUILD_DIR)/c/%: $(SRC)/c/%.c | $(BUILD_DIR)/c
	$(CC) $(CFLAGS) -MMD -MP -MF $@.d $< -o $@

# C++ compilation
$(BUILD_DIR)/cpp/%: $(SRC)/cpp/%.cpp | $(BUILD_DIR)/cpp
	$(CXX) $(CXXFLAGS) -MMD -MP -MF $@.d $< -o $@

# Java compilation
$(BUILD_DIR)/java/%.class: $(SRC)/java/%.java | $(BUILD_DIR)/java
	$(JAVAC) -d $(BUILD_DIR)/java $<

# Kotlin compilation
$(BUILD_DIR)/kotlin/%.class: $(SRC)/kotlin/%.kt | $(BUILD_DIR)/kotlin
	$(KOTLINC) -d $(BUILD_DIR)/kotlin $<

# Run specific file with extension
%.c:
	@if [ -f "$(SRC)/c/$*.c" ]; then \
		$(MAKE) --no-print-directory $(BUILD_DIR)/c/$*; \
	else \
		echo "Error: $(SRC)/c/$*.c not found"; \
		exit 1; \
	fi
	$(BUILD_DIR)/c/$*

%.cpp:
	@if [ -f "$(SRC)/cpp/$*.cpp" ]; then \
		$(MAKE) --no-print-directory $(BUILD_DIR)/cpp/$*; \
	else \
		echo "Error: $(SRC)/cpp/$*.cpp not found"; \
		exit 1; \
	fi
	$(BUILD_DIR)/cpp/$*

%.java:
	@if [ -f "$(SRC)/java/$*.java" ]; then \
		$(MAKE) --no-print-directory $(BUILD_DIR)/java/$*.class; \
	else \
		echo "Error: $(SRC)/java/$*.java not found"; \
		exit 1; \
	fi
	java -cp $(BUILD_DIR)/java $*

%.kt:
	@if [ -f "$(SRC)/kotlin/$*.kt" ]; then \
		$(MAKE) --no-print-directory $(BUILD_DIR)/kotlin/$*.class; \
	else \
		echo "Error: $(SRC)/kotlin/$*.kt not found"; \
		exit 1; \
	fi
	kotlin -cp $(BUILD_DIR)/kotlin $*Kt

# Compile specific language
c: $(C_BIN)
	@echo "All C files compiled!"

cpp: $(CPP_BIN)
	@echo "All C++ files compiled!"

java: $(JAVA_CLASS)
	@echo "All Java files compiled!"

kotlin: $(KT_CLASS)
	@echo "All Kotlin files compiled!"

# Run with FILE variable
run:
	@if [ -z "$(FILE)" ]; then \
		echo "Error: Please specify FILE=filename with extension"; \
		exit 1; \
	fi
	$(MAKE) --no-print-directory $(FILE)

# Clean build directory
clean:
	rm -rf $(BUILD_DIR)
	@echo "Build folder has been cleaned and removed!"

# Phony targets
.PHONY: all clean run c cpp java kotlin
