### Flatbuffers integrates into Android app

* Step 1:
    1. Define your schema data
    2. View syntax and structure here [link](https://google.github.io/flatbuffers/flatbuffers_guide_writing_schema.html)

* Step 2: 
    1. Copy flatbuffers package into your project

* Step 3:
    1. Generate model from your schema
    2. Format: 
        > flatc -o path/to/your/source/set --kotlin your_schema.fbs
    3. Usage: compiler syntax here [link](https://google.github.io/flatbuffers/flatbuffers_guide_using_schema_compiler.html)
    4. After your command, flatbuffers will generate code model from your schema into your defined packaged
    
That's it for **integrating** with flatbuffers. Now I generate a binary from mock json and schema, and demonstrate parse it into project.
**Syntax generate binary**
> flatc -b path/to/schema path/to/json/