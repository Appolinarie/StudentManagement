 A menu-driven console application that lets users register students, search, filter
and sort records, manage courses and skills, and generate performance reports.
Built to practise Java Collections, Object-Oriented Programming and the Stream API.

 Features
- Register students (duplicate IDs are rejected)
- Display all students and search by ID or name
- Filter passing (average >= 65) and failing students
- Sort by name or by average marks
- View all courses, unique courses, unique skills and group students by course
- Performance report: average, highest, lowest, sum and number of courses
- Best student and top 3 students
- Bonus marks (+10 per course if average > 50, capped at 100, applied once)
- Final student ranking

 Technologies
- Java 17+
- Collections: List, Map
- Stream API: filter, map, sorted, collect, flatMap, distinct, groupingBy,
  mapToDouble, summaryStatistics, max, limit, reduce

 Project Structure
- `Student.java` - student model class
- `StudentManagement.java` - logic using the Stream API
- `Main.java` - menu and user input

 How to Run
1. Clone the repository: `git clone <your-repo-url>`
2. Compile: `javac Student.java StudentManagement.java Main.java`
3. Run: `java Main`

 Author
Appolinarie MUKESHIMANA
