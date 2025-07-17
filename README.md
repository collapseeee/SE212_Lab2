# **Lab 2: Data Manipulation with Java**

**Course:** 953212 DB SYS & DB SYS DESIGN
**Student:** Nattikorn Sae-sue
**Student ID:** 672115014
**Email:** [nattikorn\_s@cmu.ac.th](mailto:nattikorn_s@cmu.ac.th)

---

### 📘 **Objective**

This lab demonstrates how to manipulate university ranking data using Java. The dataset is from the 2024 QS World University Rankings. The program applies various transformations and sorting using object-oriented programming. The program can:

* Convert all university names to lowercase
* Replace missing score values with `"0"`
* Round all score fields to integers
* Remove universities with rank ranges (e.g., "501–510")
* Sort universities by institution name (using `Comparable`)
* Export the cleaned and sorted data to a new CSV file

---

### 📂 **Project Structure**

#### `Main.java`

Contains:

* Main entry point
* Reading and parsing CSV file
* Data cleaning (lowercase, replace nulls, round values, filter rank ranges)
* Sorting university list
* Writing to a new output CSV file

#### `UniData.java`

Contains:

* Data model with all fields as `String`
* Constructor and getter methods
* `implements Comparable<UniData>` for sorting by institution name
* CSV-safe parsing using `split(",", -1)`

---

### ✅ **Features**

* Reads a CSV file with 2 header lines
* Cleans and processes score fields
* Removes universities with non-numeric rank values
* Implements sorting using `Comparable`
* Outputs cleaned and sorted results to a new file:

  ```
  QS-World-University-Rankings-2024_updated.csv
  ```

---

### 🖥️ **How to Run**

1. Ensure your terminal is in the project root directory.
2. Compile the program:

   ```bash
   javac Main.java UniData.java
   ```
3. Run the program:

   ```bash
   java Main.java 2024 QS World University Rankings 1.1 (For qs.com).csv
   ```
4. The output file `QS-World-University-Rankings-2024_updated.csv` will be generated in the same folder.

---

### 📝 **Notes**

* Make sure the original CSV file (`2024 QS World University Rankings 1.1 (For qs.com).csv`) is in the same directory as the Java files.
* All score fields are handled as strings to simplify parsing and replacement of missing values.
* The output only includes universities with a clearly defined rank (e.g., "1", "47"), not rank ranges.

---
