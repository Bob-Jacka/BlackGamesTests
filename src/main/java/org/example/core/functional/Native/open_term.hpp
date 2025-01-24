#ifndef open_term
#define open_term

    #include <cstdlib>
    #include <cstring>

    #if defined(_WIN32) || defined(_WIN64)
        #define TERMINAL_COMMAND "start cmd" //starts cmd command
    #if defined(__unix__) || defined(__unix)
        #define TERMINAL_COMMAND "gnome-terminal"
    #endif

    int main(int argc, char* argv[]) {
        system("echo Hello from c++");
        system(TERMINAL_COMMAND);
        return 0;
    }
#endif