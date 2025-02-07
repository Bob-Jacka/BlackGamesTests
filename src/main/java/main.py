"""
                        **CODE GEN.**
            *CODE GENERATION OF JAVA/KOTLIN GAMES CLASSES*
This file need for code generation of games classes in kotlin or java language.

Requirements:
    1. Python interpreter 3.12 or higher.
    2. No fear.
    3. No respect.

RULES:
    1. Functions starting with double underscore are main functionalities and use only in this file.
    2. Functions starting and ending with double underscores are private functions. They use only in main functionalities.
    3. Functions that have no underscores are public.
    4. Key for dictionary should be like '<short_name>{0-9}', ex. 'mnme0', means - method name 0

Instruction to use:
    1. Change name of the game in main entry point.
    2. pass
    3. pass

Code gen architecture:
                                                            Program entry point.
                                                                      |
                                                         _______ code_gen ___________________________
                                                        |                                           |
                             __get_values_from_interface                                __get_method_from_interface
                            /           |               \                               |           |             \
        __get_interface_data__    __split_line__   __update_keys__    __get_interface_data__   __split_line__   __update_keys__
                                    /  \                                                          /      \
             __get_method_arguments__  __clear_string__                     __get_method_arguments__   __clear_string__


Author - Cupcake_WRLD.
Version: 0.0.2.
since 06.02.2025.
"""
from typing import (
    Collection,
    TextIO
)


class class_model:
    class_name: str
    class_values: Collection
    class_methods: Collection
    package_name: str = 'package org.example.core.games.sc_games'
    file_descriptor: TextIO

    def __init__(self, class_name: str, file_writer: TextIO, class_values: Collection, class_methods: Collection):
        """
        Class that represents printer class in java or kotlin.
        Class contains actions to print main arhitecture of class by interface.
        :param class_values: container of values in class.
        :param class_methods: container of methods in class.
        :param file_writer: file descriptor.
        """
        self.class_name = class_name
        self.class_methods = class_methods
        self.class_values = class_values
        self.file_descriptor = file_writer

    def print_methods(self):
        """
        Method for printing methods of class in file.
        :return: None.
        """
        for method in self.class_methods:
            self.print_to_file(method)
            self.print_to_file('\n')  # TODO дописать метод

    def print_class_values(self):
        """
        Method for printing values of class in file.
        :return: None.
        """
        for value in self.class_values:
            self.print_to_file(value)
            self.print_to_file('\n')  # TODO дописать метод

    def print_package(self):
        self.print_to_file(self.package_name)
        self.print_to_file('\n')

    def print_class_signature(self):
        self.print_to_file(f'class {self.class_name.capitalize()} ')
        self.print_to_file(' { \n\n\n\n } ')

    def print_to_file(self, string: str):
        """
        Syntax sugar for write method.
        :param string: string to write.
        :return: None.
        """
        self.file_descriptor.write(string)


import os
import stat

sc_games_dir: str = '../../main/java/org/example/core/games/sc_games/'
slot_games_dir: str = '../../main/java/org/example/core/games/Slots/'
main_interface_path: str = '../../main/java/org/example/core/main_functionalities/Interfaces.kt'

ignorable_symbols = (')', ':', '{', '}', ',')
"""
Symbols that need to ignore in strings.
"""

kotlin_ext = '.kt'
kotlin_method = 'fun'
kotlin_value = 'val'
kotlin_void_return_type = ': Unit'

java_ext = '.java'
java_method = 'public '
java_value = 'private '
java_void_type = 'void'


def __update_keys__(key_for_name: str, key_for_type: str, key_for_method_params: str = None) -> tuple[
    str, str, str]:
    """
    Private Function for updating key integer number.
    :param key_for_name: Key value for method / value name.
    :param key_for_type: Key value for method / value type.
    :param key_for_method_params: Key value for method parameters, by default equals None.
    :return: tuple with three string values. But if this function invoked in values function, then last element will be equals None.
    """
    key_to_return_name = key_for_name[:-1] + str(int(key_for_name[-1:]) + 1)
    key_to_return_type = key_for_type[:-1] + str(int(key_for_type[-1:]) + 1)
    if key_for_method_params is not None:
        key_to_return_param = key_for_method_params[:-1] + str(int(key_for_method_params[-1:]) + 1)
    else:
        key_to_return_param = None
    return key_to_return_name, key_to_return_type, key_to_return_param


def __clear_string__(string: str) -> str:
    """
    Private function for clearing string.
    :param string: string, that needs to clean.
    :return: cleared string (without symbols that represented in ignorable_symbols).
    """
    cleared: str = ''
    for char in string:
        if char in ignorable_symbols:
            cleared = string.replace(char, '')
        else:
            cleared += char
    return cleared


def __get_method_arguments__(func_line: list[str]) -> list[tuple[str, str]]:
    """
    Process string to get a pair of value name, value type.
    :param func_line: String to process.
    :return: list with tuples, where first string is name, second is type.
    """
    if len(func_line):
        to_return: list[tuple[str, str]] = list()
        for val in func_line:  # val = string
            nxt_elem = func_line[func_line.index(val) + 1]
            to_return.append((val, nxt_elem))
        return to_return


def __split_line__(str_to_split: str, split_by: str = ' ') -> tuple[str, list[tuple] | None, str | None]:
    """
    Split string clearly.
    First arg - name.
    Second arg - method args, if it not method.
    Third arg - return value.
    :param str_to_split: string to split in list.
    :param split_by: split by what?
    :return: tuple with three (two if value is not None) arguments.
    """
    cleared_list: list = list()
    split = str_to_split.split(sep=split_by)
    for elem in split:  # strings in list
        if elem.find('(') != -1:
            two_elem = elem.split('(')
            cleared_list.append(__clear_string__(two_elem[0]))
            cleared_list.append(__clear_string__(two_elem[1]))
            continue
        for char in elem:  # chars in string
            if char in ignorable_symbols:
                cleared_list.append(__clear_string__(elem))
    method_args = __get_method_arguments__(cleared_list[1:])
    return cleared_list[0], method_args, None


def __get_method_from_interface(interface_list: list[str]) -> dict[str, str]:
    """
    Function for retrieve methods from interface.
    Map schema - First arg is <method name>, second arg is <method values>, third arg is <return type>.
    :return dictionary where first element is *method name* and second element is *type of element*.
    """
    methods_of_interface: dict[str, str] = dict()
    method_name_key = 'mnme0'
    input_params_key = 'mpar0'
    return_type_key = 'mret0'

    for interface in interface_list:
        for line in __get_interface_data__(interface):
            if line.startswith(kotlin_method):
                split_line = __split_line__(line)
                method_name = split_line[1]
                method_params = split_line[2]
                method_return_value = split_line[3]

                methods_of_interface.update({method_name_key: method_name})
                methods_of_interface.update({input_params_key: method_params})
                methods_of_interface.update({return_type_key: method_return_value})
                __update_keys__(method_name_key, input_params_key, return_type_key)

    if len(methods_of_interface) == 0:
        print('There are no methods in this interface.')
    else:
        return methods_of_interface


def __get_values_from_interface(interface_list: list[str]) -> dict[str, str]:
    """
    Function for retrieve values from interface.
    :return dictionary where first element is *value name* and second element is *type of value*.
    """
    values_of_interface: dict[str, str] = dict()
    value_name_key = 'vnme0'
    value_type_key = 'vret0'

    for interface in interface_list:
        for line in __get_interface_data__(interface):
            if line.startswith(kotlin_method):
                split_line = __split_line__(line)
                value_name = split_line[1]
                value_type = split_line[2]

                values_of_interface.update({value_name_key: value_name})
                values_of_interface.update({value_type_key: value_type})
                __update_keys__(value_name_key, value_type_key)

    if len(values_of_interface) == 0:
        print('There are not values in interface.')
    else:
        return values_of_interface


def __get_interface_data__(interface_name: str) -> str:
    """
    Opens data in interface file in functionalities directory.
    Get data in interface between curly brackets.
    :return: string between '{' and '}'
    """
    os.chmod(main_interface_path, stat.S_IWUSR)
    with open(main_interface_path, 'r') as interface_file:
        read_file = interface_file.read()
        read_file.find(f'interface {interface_name}')
        interface_start = read_file.index('{')
        interface_end = read_file.index('}', interface_start + 1)
        interface_data = read_file[interface_start:interface_end]
        os.chmod(main_interface_path, stat.SF_IMMUTABLE)
        return interface_data


def code_gen(game_name: str, lang_ext: str, interfaces: list):
    """
    Function for completing class page.
    :param game_name: name of the game.
    :param lang_ext: file extension of language. ex. in kotlin - '.kt'.
    :param interfaces: list, containing interfaces names.
    :return: None. But there is a new file of class.
    """
    print('Code gen start working.')
    class_values = __get_values_from_interface(interface_list=interfaces)
    class_methods = __get_method_from_interface(interface_list=interfaces)
    with open(sc_games_dir + game_name + lang_ext, 'w+') as game_file:
        class_printer = class_model(file_writer=game_file, class_values=class_values,
                                    class_methods=class_methods)
        class_printer.print_package()
    print('Code gen finished working.')


"""
Entry point of code gen program.
"""
if __name__ == '__main__':
    print(__split_line__('fun change_coef(which_block: int, up: bool, howMany: int)'))
    # code_gen('mines', kotlin_ext, ['EIAuto'])
