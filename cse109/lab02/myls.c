#include <stdio.h>
#include <stdbool.h>
#include <string.h> // for strcmp
#include <dirent.h>

int main(int argc, char** argv) {

  // Set up flag variables
  bool a_flag = false;
  bool l_flag = false;
  
  // Check to see if flags are set in argv
  for (int ix = 0; ix < argc; ix++) {
    if (strcmp(argv[ix],"-a") == 0) {
      a_flag = true;
    }
    if (strcmp(argv[ix],"-l") == 0) {
      l_flag = true;
    }
  }

  // Test to see if flags were set
  // Open dir
  DIR* dir = opendir(".");
  struct dirent* entry;
  // Read file
  while((entry = readdir(dir)) != NULL) {
    // get name
    char* name = entry->d_name;
    // get type
    char type = entry->d_type;
    //when both flags are present
    if (a_flag==true && l_flag==true)
    {   
        if (type == 4) {
            printf("%s Folder\n", name);
        }
        if (type == 8) {
            printf("%s File\n", name);
        }
    }
    //when neither flags are present
    else if (a_flag==false && l_flag==false)
    {
      if (name[0]!='.')
      {
        printf("%s  ", name);
      }
      
    }
    //when a flag is present
    else if (a_flag==true && l_flag==false)
    {
        printf("%s  ", name);
    }
    //when l flag is present
    else if (a_flag==false && l_flag==true)
    {
      if (name[0]!='.')
      {
        // printf("%s  ", name);
        if (type == 4) {
            printf("%s Folder\n", name);
        }
        if (type == 8) {
            printf("%s File\n", name);
        }
      }
           
    }
  }
  printf("\n");
  closedir(dir);
  return 0;
}
