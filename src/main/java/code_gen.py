"""
                                        **CODE GEN.**
                        *CODE GENERATION OF JAVA/KOTLIN GAMES CLASSES*
            This file need for code generation of games classes in kotlin or java language.

Requirements:
    1. Python interpreter 3.12 or higher version.
    2. No fear. No respect.
    3. kotlin file with interfaces.

RULES:
    1. Functions starting with double underscore are main functionalities and use only in this file.
    2. Functions starting and ending with double underscores are private functions. They use only in main functionalities.
    3. Functions that have no underscores are public.
    4. Load only kotlin file with interfaces, other does not supported.

Instruction to use:
    1. Enter game name in console input;
    2. Enter game type, see supported_game_types list;
    3. Enter interfaces names in console input;
    4. Enter programming language. Warning inputted language should be in supported_languages global list variable.
    5. *Optional - if your language does not support, you need to initialize it in class_printer and create class schema for it

Code gen architecture:
                                                            Program entry point_________________________
                                                                      |                                 \
                                                    ____________code_gen____________________________  __tests__(for testing program work)
                                                    |                                               |
                             __get_values_from_interface___                              __get_method_from_interface_____________
                            /           |                  \                            |                   |                    \
            interface_file_data    __split_line_to_value__  __clear_string__     interface_file_data   __split_line_to_method__   __clear_string__



Author - Cupcake_WRLD.
Version: 1.0.0.
since 06.02.2025.
"""

program_name = 'Code gen'
"""
Name of the program to print in various console outputs.
"""

import re
from copy import deepcopy
from os import PathLike
from os.path import exists
from typing import (
    TextIO,
    final
)

from termcolor import colored

supported_languages: tuple = ('java', 'kotlin')
"""
Languages that supported in code gen program.
"""

supported_game_types = ('sc', 'slot')
"""
Game types that supported by code gen.
"""

sc_games_dir: str | PathLike = 'src/main/java/org/example/core/games/sc_games/'
"""
Directory path to sc games dir.
"""

slot_games_dir: str | PathLike = 'src/main/java/org/example/core/games/Slots/'
"""
Directory path to slot games dir.
"""

main_interface_path: str | PathLike = 'src/main/java/org/example/core/main_functionalities/Interfaces.kt'
"""
Global instance of entry point to interface file.
Only kotlin file with interfaces supported.
"""

ignorable_symbols = (')', ':', '{', '}', ',')
"""
Symbols that need to ignore in strings while scanning.
"""


class Class_schema:
    """
    Class depending on schema.
    Data class that containing unique class features and words.

    Rule:
        1. In class_keywords use such keys like - interface_inherit_word, method_start_word, is_use_semicolons and value_modifier{number}, method_modifier{number}, etc.
    """

    interface_inherit_word: str
    """
    Word that means inheritance, ex. in C++ ':', in kotlin ':', in java 'implements'
    """

    method_start_word: str
    """
    Word that means start of the method in language.
    """

    override_interface_word: str
    """
    Word that means override interface item in language.
    """

    no_value: str
    """
    Value that used for not values, ex. 'null' or 'None'.
    """

    is_use_semicolons: bool = False
    """
    Parameter for languages that uses semicolon ( ; ) like java lang.
    Contains default value False.
    """

    is_use_curly_brackets: bool = True
    """
    Parameter for languages that uses curly brackets ( { } ), like java or kotlin lang, but python does not.
    Contains default value True. 
    """

    value_modifier_words: list[str | None] = list()
    """
    Value modifier words that class contains.
    """

    method_modifier_words: list[str | None] = list()
    """
    Method modifier words that class contains.
    """

    def __init__(self, class_keywords: dict[str, str]):
        try:
            counter = 0
            self.interface_inherit_word = class_keywords['interface_inherit_word']
            self.method_start_word = class_keywords['method_start_word']
            self.value_start_word = class_keywords['value_start_word']
            self.override_interface_word = class_keywords['override_word']
            self.no_value = class_keywords['no_value']

            self.is_use_semicolons = bool(class_keywords['is_use_semicolons'])
            self.is_use_curly_brackets = bool(class_keywords['is_use_curly_brackets'])

            for _ in class_keywords:
                key = f'value_modifier{counter}'
                if class_keywords.__contains__(key):
                    self.value_modifier_words.append(class_keywords.get(key))

            for _ in class_keywords:
                key = f'method_modifier{counter}'
                if class_keywords.__contains__(key):
                    self.method_modifier_words.append(class_keywords.get(key))
        except Exception as e:
            print(f'Error occurred during constructing class_schema object - {e.with_traceback(None)}.')


######################################################################################################
# Place where you can write class scheme for your languages.

# Keys for class schema dict:

# interface_inherit_word,
# method_start_word,
# value_start_word,

# is_use_semicolons,
# is_use_curly_brackets,

# and

# value_modifier{number}, number from 0 to some_int_value
# method_modifier{number} number from 0 to some_int_value

# Important that 'is_use_semicolons' and 'is_use_curly_brackets' values contains boolean value that starts from uppercase letter.

kotlin_keywords = ('interface',
                   'interface ',
                   'fun',
                   'fun ',
                   'val',
                   'val ',
                   'var',
                   'var ')
"""
Keywords that used in kotlin language.
"""

java_keywords = ('interface',
                 'interface ',
                 'private',
                 'private ',
                 'public',
                 'public ',
                 'protected',
                 'protected ',
                 'final',
                 'final ')
"""
Keywords that used in java language.
"""

kotlin_cls_schema: Class_schema = Class_schema(
    class_keywords={
        'interface_inherit_word': ': ',
        'method_start_word': 'fun ',
        'value_start_word': 'var ',
        'value_start_word1': 'val ',
        'no_value': 'null',
        'override_word': 'override',

        'is_use_semicolons': 'False',
        'is_use_curly_brackets': 'True',

        'class_modifier0': '',
        'class_modifier1': 'enum',

        'value_modifier0': 'public',
        'value_modifier1': 'private',
        'value_modifier2': 'protected',

        'method_modifier0': 'public',
        'method_modifier1': 'private',
        'method_modifier2': 'protected',
    }
)

java_cls_schema = Class_schema(
    class_keywords={
        'interface_inherit_word': 'implements ',
        'method_start_word': 'public ',
        'value_start_word': 'public ',
        'no_value': 'null',
        'override_word': '@Override',

        'is_use_semicolons': 'True',
        'is_use_curly_brackets': 'True',

        'class_modifier0': 'final',
        'class_modifier1': 'sealed',
        'class_modifier2': 'abstract',
        'class_modifier3': 'enum',

        'value_modifier0': 'private',
        'value_modifier1': 'public',
        'value_modifier2': 'protected',
        'value_modifier3': 'final',

        'method_modifier0': 'private',
        'method_modifier1': 'public',
        'method_modifier2': 'protected',
        'method_modifier3': 'final',
    }
)

cls_schemas: dict = {
    'kotlin': kotlin_cls_schema,
    'java': java_cls_schema
}
"""
Dict with cls schemas to return.
"""


def __get_cls_schema__(key: str) -> Class_schema | None:
    """
    Lazy getter for cls schema.
    :return: class schema or None if not found.
    """
    return cls_schemas.get(key)


######################################################################################################

######################################################################################################
# Section with standard realizations.
# Includes standard value realizations and standard method realizations.

value_realizations: dict[str, tuple[int, int]] = {
    'play_btn': (960, 730),
    'balance_btn': (960, 938),
    'sound_btn': (1780, 145),
    'history_btn': (1690, 145),
    'game_into': (1700, 165),
    'upBet_btn': (1032, 863),
    'downBet_btn': (885, 863),
    'blockchaininfo_btn': (1780, 250),
    'playAudioEffects_btn': (1735, 145),

    'settings_btn': (960, 938),
    'sound_btn': (1412, 185),
    'how_to_play': (1518, 185),

    'play_btn': (968, 920),
    'bet_btn': (450, 640),
    'rules_btn': (1490, 959),
    'plus_btn': (869, 965),
    'minus_btn': (1065, 965),
    'autoBet_btn': (445, 790),
}
"""
Key type is string. Value type is tuple int, int.
Standard value realizations for IGameSC, ICasualGame, IGameSC, ICrashGame and ISlot.
"""

method_realizations_kotlin: dict[str, str] = {
    'enter_in_history': """
        click_On(history_btn)
    """,
    'set_sound_on': """
        isSound = state
        if (!isSound) {
            isSound = true
            click_On(sound_btn)
        } else {
            isSound = false
            click_On(sound_btn)
        }
    """,
    'change_bet': """
        if (up) {
            repeat(howMany) {
                click_On(upBet_btn)
            }

        } else {
            repeat(howMany) {
                click_On(downBet_btn)
            }
        }
    """,
    'enter_blockchain': """
        click_On(blockchaininfo_btn)
    """,
    'enter_game_info': """
        click_On(game_info)
    """,
    'enter_settings': """
        click_On(settings_btn)
    """,
    'get_first_block': """
        return first_block
    """,
    'get_second_block': """
        return second_block
    """,
    'start_game': """
        click_On(play_btn)
    """,
    'get_in_rules': """
        click_On(rules_btn)""",
    'change_bet_plus': """
        repeat(howMany) {
        click_On(plus_btn)
    }
    """,
    'change_bet_minus': """
        repeat(howMany) {
        click_On(minus_btn)
    }
    """,
    'auto_bet_on': """
        click_On(autoBet_btn)
    """,
    'close_rules': """
        click_On(close_rules_btn)
    """,
}
"""
Standard realizations for IGameSC, ICasualGame, IGameSC, ICrashGame and Slot games.
"""

import_realizations: dict[str, str] = {
    'click_On': "org.example.core.main_functionalities.ActionController.click_On",
    'wait_For': "org.example.core.main_functionalities.ActionController.wait_For"
}
"""
Key - method name in auto testing library, Value - full path to method.
Standard realization of import directive by kotlin language.
"""


######################################################################################################


def __settings_menu__():
    """
    Menu for settings.
    :return: nothing.
    """
    print('Select one of items.')
    print('Settings:')
    print('1. Change interface file path;')
    print('2. Get standard method realizations;')
    print('3. Exit program.')
    user_input: int
    try:
        user_input = int(__input_from_user__('Enter int value'))
        match user_input:
            case 1:
                global main_interface_path
                print('Enter path to new interface.')
                main_interface_path = __input_from_user__('')
            case 2:
                print('Enter path to file with realizations.')
                path_to_standard_realizations: str | PathLike = __input_from_user__('')  # TODO доделать.
            case 3:
                print('Bye.')
                exit()
    except Exception as e:
        print(f'Error occurred in settings menu - {e.with_traceback(None)}.')


def print_error(msg: str):
    """
    Static function for printing error with red color.
    :param msg: message to print.
    """
    print(colored(msg, 'red'))


def print_success(msg: str):
    """
    Static function for printing success with green color.
    :param msg: message to print.
    """
    print(colored(msg, 'green'))


def print_info(msg: str):
    """
    Static function for printing info messages with blue color.
    :param msg: message to print.
    """
    print(colored(msg, 'blue'))


def __get_interface_data__() -> list[str]:
    """
    Opens data in interface file in functionalities directory.
    Get data in interface between curly brackets.
    :return: string between '{' and '}'
    """
    access: bool = exists(main_interface_path)
    if access:
        os.chmod(main_interface_path, stat.S_IWUSR)
        with open(main_interface_path, 'r') as interface_file:
            interface_file_data = interface_file.read().splitlines()
            os.chmod(main_interface_path, stat.SF_IMMUTABLE)
            return interface_file_data
    else:
        raise Exception('Main interface does not exist or not found.')


def __delete_comments_in_file__(input_list: list[str]) -> list[str]:
    """
    Private static private function for deleting comments in interface file.
    :param input_list: interface file with comments.
    :return: interface file without comments.
    """
    try:
        to_return_list: list[str] = list()
        for line in input_list[:]:
            if line != '':
                cleared_line = line.strip()
                str_to_list: list[str] = cleared_line.split()
                if str_to_list[0] in kotlin_keywords:
                    to_return_list.append(cleared_line)
                else:
                    input_list.remove(line)
            else:
                input_list.remove(line)
        return to_return_list
    except Exception as e:
        print_error(f'{e.with_traceback(None)}')


def __interfaces_indexes__() -> list[int]:
    """
    Function for getting interfaces indexes.
    :return: indexes of the interfaces.
    """
    try:
        to_return: list[int] = list()
        for elem in interface_file_data:
            if elem.startswith('interface'):
                index = interface_file_data.index(elem)
                to_return.append(index)
        return to_return
    except Exception as e:
        print(f'Error in interface indexes - {e.with_traceback(None)}.')


@final
class Class_model_printer:
    """
    Class that responsible for printing class in java or kotlin, or another supported language.
    This class contains actions to print main arhitecture of class by interface.
    """

    class_name: str
    class_values: list
    class_methods: list
    package_name: str = 'package org.example.core.games.sc_games'
    class_to_print: str
    file_descriptor: TextIO
    """
    Standard file descriptor of the file.
    """

    class_schema_obj: Class_schema
    """
    Schema of class to print.
    """

    def __init__(self, class_name: str, game_type: str, class_to_print: str, file_writer: TextIO, class_values: list, class_methods: list, class_schema_obj: Class_schema):
        """
        :param class_name: value that represents class name, which will be printed.
        :param class_values: container of values in class.
        :param class_methods: container of methods in class.
        :param class_schema_obj: parameter responsible for language schema class.
        :param file_writer: file descriptor.
        """
        self.class_name = class_name
        self.class_values = class_values
        self.class_methods = class_methods
        self.class_to_print = class_to_print

        self.class_schema_obj = class_schema_obj
        self.file_descriptor = file_writer

    def print_class_methods(self):
        """
        Method for printing methods of class in file.
        depending on received class to print.
        :return: None.
        """
        if self.class_methods is not None:
            for method in self.class_methods:
                method_printer = self.method(self.file_descriptor, self.class_schema_obj)
                match self.class_to_print:
                    case 'java':
                        method_printer.print_method_java(method[0], method[2], args=method[1])
                    case 'kotlin':
                        method_printer.print_method_kotlin(method[0], method[2], args=method[1])
                self.print_to_file('\n')
                self.print_to_file('\n')
                print_success('Method printed.')
        else:
            print_error('Class methods is None.')

    def print_class_values(self):
        """
        Method for printing values of class in file.
        depending on received class to print.
        :return: None.
        """
        if self.class_values is not None:
            for value in self.class_values:
                value_printer = self.value(self.file_descriptor, self.class_schema_obj)
                match self.class_to_print:
                    case 'java':
                        value_printer.print_value_java(value[0], value[1])
                    case 'kotlin':
                        value_printer.print_value_kotlin(value[0], value[1])
                self.print_to_file('\n')
                print_success('Value printed.')
        else:
            print_error('Class values is None.')

    def print_package(self):
        """
        Prints package name.
        :return: None.
        """
        if self.package_name is not None:
            self.print_to_file(self.package_name)
            if self.class_schema_obj.is_use_semicolons:
                self.print_to_file(';')
            self.print_to_file('\n')
            print_success('Package name printed.')
        else:
            print_error('Package name is None.')

    def print_class_imports(self):
        """
        Method for printing imports in class.
        depending on received class to print.
        :return: None.
        """
        for import_directive in import_realizations:
            self.print_to_file(f'import {import_realizations[import_directive]}\n')
        # TODO depending on language.
        print_success('Imports printed.')

    def print_class_signature(self, interfaces_to_implement: list = None):
        """
        Prints class signature, ex. - class <name> implements ... {.
        :return: None.
        """
        if self.class_name is not None:
            self.print_to_file('\n')
            self.print_to_file(f'class {self.class_name.capitalize()} ')
            if interfaces_to_implement is not None:  # Yes, I know that does not possible.
                self.print_to_file(self.class_schema_obj.interface_inherit_word)
            interfaces_count = len(interfaces_to_implement)
            for interface in interfaces_to_implement:
                self.print_to_file(f'{interface}')
                if interfaces_count > 1:
                    self.print_to_file(', ')
                    interfaces_count -= 1
            self.print_to_file(' {\n\n')
            print_success('Class signature printed.')
        else:
            print_error('Class name is None.')

    def print_to_file(self, string_to_proceed: str):
        """
        Syntax sugar for write to file method.
        :param string_to_proceed: string to write.
        :return: nothing.
        """
        try:
            self.file_descriptor.write(string_to_proceed)
        except Exception as e:
            print_error(f'An error occurred in print to file - {e.with_traceback(None)}.')

    def print_end_of_file(self):
        """
        Prints end of the file.
        :return: nothing.
        """
        try:
            self.print_to_file('\n}')
        except Exception as e:
            print_error(f'An error occurred in print end of file - {e.with_traceback(None)}.')

    class method:
        """
        Nested class for method modeling.
        Language indifferent.
        """
        kotlin_method = 'fun'
        java_method = 'public '
        java_void_type = 'void'

        def __init__(self, printer: TextIO, class_schema_info: Class_schema):
            self.class_schema_info = class_schema_info
            self.printer = printer

        def print_method_kotlin(self, name, return_value, args=''):
            """
            Prints methods in kotlin language.
            :param name: name of the method and key for standard realization.
            :param return_value: return value of the method.
            :param args: arguments of the method.
            :return: nothing.
            """
            self.printer.write(f'\t{self.class_schema_info.override_interface_word} ')
            if return_value is None:
                self.printer.write(f'fun {name}({args})')
            else:
                self.printer.write(f'fun {name}({args}) {return_value}')
            self.printer.write(' {')
            if name in method_realizations_kotlin:
                self.printer.write(method_realizations_kotlin[name])
                self.printer.write('}')
            else:
                self.printer.write('\n')
                self.printer.write('\n')
                self.printer.write('\t}')

        @staticmethod
        def __swap_arguments__(string_to_swap: str) -> str:
            """
            Private static function for swap arguments from kotlin notation to java.
            :param string_to_swap: string that needs to change.
            :return: swapped string.
            """
            to_return: list[str] | str = list()
            if string_to_swap != '':
                split = string_to_swap.split()
                tmp: str
                for item in split:
                    item = __clear_string__(item)
                    to_return.append(item)
                to_return.reverse()
                stringbuilder = ''
                counter = 0
                for string in to_return[:]:
                    if counter == 2:
                        stringbuilder = stringbuilder.strip()
                        stringbuilder = stringbuilder + f', {string} '
                        counter = 0
                    else:
                        stringbuilder = stringbuilder + f'{string} '
                        counter += 1
            else:
                return ''
            return stringbuilder.strip()

        def print_method_java(self, name, return_value, args=''):
            """
            Prints methods in java language.
            :param name: name of the method and key for standard realization.
            :param return_value: return value of the method.
            :param args: arg of the method.
            :return: nothing.
            """
            if args is None:
                args = ''
            if return_value is None:
                return_value = self.java_void_type
            self.printer.write('\t' + self.class_schema_info.override_interface_word)
            self.printer.write('\n')
            self.printer.write(f'\tpublic {return_value} {name}({self.__swap_arguments__(args)})')
            self.printer.write(' {')
            self.printer.write('\n')
            self.printer.write('\n')
            self.printer.write('\t}')

    class value:
        """
        Nested class for value modeling.
        Language indifferent.
        """

        kotlin_value = 'val'
        java_value = 'private '
        java_void_type = 'void'

        def __init__(self, printer: TextIO, class_schema: Class_schema):
            self.printer = printer
            self.class_schema = class_schema

        def print_value_kotlin(self, name, value_type):
            if name in value_realizations:
                self.printer.write(
                    f'\tprivate val {name}: {value_type} = {value_type}{value_realizations[name]}')  # TODO maybe problems because value_type, may not be accessible in this line.
            else:
                self.printer.write(f'\tprivate val {name}: {value_type}? = {self.class_schema.no_value}')  # There is no standard realization for this method.

        def print_value_java(self, name, value_type):
            self.printer.write(f'\t private final {value_type} {name} = {self.class_schema.no_value};')


import os
import stat

interface_file_data: list[str] = __delete_comments_in_file__(__get_interface_data__())
"""
String value that holds all Interfaces.kt file.
"""

interface_indexes = __interfaces_indexes__()
"""
Indexes of the interfaces all over the file.
"""


def __read_interface__(interface_name: str) -> list[str]:
    """
    Read interfaces and pack them as a container.
    :return: list, containing strings inside interface.
    """
    if interface_name is not None:
        global interface_file_data
        return_list: list[str] = list()
        name_start_mask = re.compile(f'interface {interface_name} ')
        full_masked_name = list(filter(name_start_mask.match, interface_file_data))  # ['interface IGameSC : IGame {']
        interface_start: int = interface_file_data.index(full_masked_name[0])
        try:
            interface_end = interface_indexes[interface_indexes.index(interface_start) + 1]
            interface_data = deepcopy(interface_file_data)[interface_start:interface_end]
        except Exception as e:
            raise RuntimeError(f'Error occurred in __read_interface__ function - {e.with_traceback(None)}.')
        for line in interface_data:
            if line != '':
                return_list.append(line)
        return return_list
    else:
        raise Exception(colored(f'interface_name "{interface_name}" should not be None.', 'red'))


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


def __split_line_to_method__(str_to_split: str, split_by: str = ' ') -> tuple[str, str | None, str | None] | None:
    split_line: list
    method_name: str
    method_arguments_value: str | None
    method_return_value: str | None
    if str_to_split is not None and len(str_to_split) > 1:
        split_line = str_to_split.split(sep=split_by, maxsplit=1)
        method_params_start = split_line[1].index('(')
        method_params_end = split_line[1].index(')')
        match len(split_line):
            case 2:
                name_with_params: str = split_line[1]
                method_name = name_with_params[0:method_params_start]
                method_arguments_value = name_with_params[method_params_start + 1: method_params_end]
                if method_arguments_value == '(':
                    method_arguments_value = None
                method_return_value = None
            case 3:
                name_with_params = split_line[1]
                method_name = name_with_params[0:name_with_params.index('(')]
                method_arguments_value = name_with_params[method_params_start: method_params_end]
                method_return_value = split_line[2]
            case _:
                print('An error occurred during splitting line to method.')
                return None
    return method_name, method_arguments_value, method_return_value


def __split_line_to_value__(str_to_split: str, split_by: str = ' ') -> tuple[str, str | None] | None:
    split_line: list
    value_name: str
    value_type: str
    if str_to_split is not None and len(str_to_split) > 1:
        split_line = str_to_split.split(sep=split_by)
        match len(split_line):
            case 2:
                value_name: str = __clear_string__(split_line[1])
            case 3:
                value_name = __clear_string__(split_line[1])
                value_type = split_line[2]
            case _:
                print('An error occurred during splitting line to value.')
                return None
    return value_name, value_type


def __get_method_from_interface(interface_list: list[str]) -> list[list] | None:
    """
    Function for retrieve methods from interface.
    Map schema - First arg is <method name>, second arg is <method values>, third arg is <return type>.
    :return dictionary where first element is *method name* and second element is *type of element*.
    """
    res: list[list] = list()
    for interface in interface_list:
        interface_data = __read_interface__(interface)
        for line in interface_data[:]:
            if line.startswith(Class_model_printer.method.kotlin_method):
                split_line = __split_line_to_method__(line)
                method_name = split_line[0]  # name
                method_args = split_line[1]  # method arguments
                method_type = split_line[2]  # type
                res.append(list((method_name, method_args, method_type)))
    if len(res) == 0:
        print_error(f'There are no methods in {interface_list} interface.')
    else:
        return res


def __get_values_from_interface(interface_list: list[str]) -> list[list]:
    """
    Function for retrieve values from interface.
    :return dictionary where first element is *value name* and second element is *type of value*.
    """
    res: list[list] = list()
    for interface in interface_list:
        interface_data = __read_interface__(interface)
        for line in interface_data[:]:
            if line.startswith(Class_model_printer.value.kotlin_value):
                split_line = __split_line_to_value__(line)
                value_name = split_line[0]  # name
                value_type = split_line[1]  # type
                res.append(list((value_name, value_type)))
    if res is not None and len(res) == 0:
        print_error(f'There are no values in {interface_list} interface.')
    else:
        return res


kotlin_ext = '.kt'
java_ext = '.java'


# Main function
def code_gen(game_name: str, game_type: str, print_class: str, interfaces: list) -> None:
    """
    Function for complete printing class page.
    :param game_type: type of the game to print.
    :param game_name: name of the game.
    :param print_class: class type for print.
    :param interfaces: list, containing interfaces names.
    :return: None. But there is a new file of class.
    """
    if game_name is not None and print_class is not None:
        if print_class in supported_languages:
            lang_ext: str
            match print_class:
                case 'java':
                    lang_ext = java_ext
                case 'kotlin':
                    lang_ext = kotlin_ext
                case _:
                    raise RuntimeError(f'{print_class} - Language does not support.')
            print_info(f'{program_name} start working.')
            class_values = __get_values_from_interface(interface_list=interfaces)
            class_methods = __get_method_from_interface(interface_list=interfaces)
            with open(sc_games_dir + game_name + lang_ext, 'w+') as game_file:
                class_printer = Class_model_printer(
                    class_name=game_name,
                    game_type=game_type,
                    file_writer=game_file,
                    class_values=class_values,
                    class_methods=class_methods,
                    class_schema_obj=__get_cls_schema__(print_class),
                    class_to_print=print_class
                )
                class_printer.print_package()
                game_file.write('\n')
                class_printer.print_class_imports()
                class_printer.print_class_signature(interfaces_to_implement=interfaces)
                class_printer.print_class_values()
                game_file.write('\n')
                class_printer.print_class_methods()
                class_printer.print_end_of_file()
            print_info(f'{program_name} finished working.')
        else:
            print_error(f'Class type for print is not valid, expected {supported_languages}, received "{print_class}".')
    else:
        print_error('Neither game name is None or print_class is None.')


def __interfaces_names__() -> list:
    """
    Private static function for interface list.
    :return: list, only with interfaces names.
    """
    to_return: list = list()
    for index in interface_indexes:
        line = interface_file_data[index]
        line = __clear_string__(line)
        line = line.replace('interface ', '')
        if line.find(':') != -1:
            line = line[0: line.index(':')]
        line = line.strip()
        to_return.append(line)
    return to_return


interfaces_names_list = __interfaces_names__()
"""
Autogenerated list of all interfaces in given file.
"""


def __tests__():
    """
    Function for end-to-end test.
    Contains list of tests to execute.
    """
    test_list: list = list(
        (
            code_gen('mines', 'sc', 'java', ['IGameSC']),
            code_gen('mines1', 'sc', 'java', []),
            code_gen('mines123', 'sc', 'kotlin', ['IGameSC', 'IEPreselects', 'ICrashGame']),
            code_gen('mines2', 'sc', 'groovy', ['IGameSC', 'ICrashGame', 'IEPreselects']),
            code_gen('__', 'sc', '', ['IGameSC']),
            code_gen('__', '', 'java', ['IGameSC']),
            code_gen('', 'sc', 'kotlin', ['IGameSC'])
        )
    )
    test_count = len(test_list)
    counter = 0
    for test in test_list:
        print(f'№{counter} of {test_count} tests.')
        exec(test)
        print(f'Test executed - №{counter}.')


def __input_from_user__(topic: str) -> str:
    """
    Error safety beautiful input from user.
    :param topic: string that will be printed before every input.
    :return: string value.
    """
    input_cursor = '>> '
    try:
        while True:
            user_input: str
            print('Enter "settings" - to enter settings menu;')
            print('Enter "see" - to see all available interfaces;')
            print(f'Enter "tests" - to run {program_name} tests;')
            print(topic)
            print(input_cursor, end='')
            user_input = str(input())
            match user_input:
                case 'settings':
                    __settings_menu__()
                    user_input = __input_from_user__(topic)
                case 'see':
                    print('Available interfaces:')
                    for interface in interfaces_names_list:
                        print(f'\t {interface}')
                    print()
                    continue
                case 'tests':
                    print('Running tests:')
                    __tests__()
                case _:
                    return user_input
            print()
            return user_input
    except Exception as e:
        print(f'Error in input from user - {e.with_traceback(None)}.')


"""
Entry point of code gen program.
"""
if __name__ == '__main__':
    game_name_input: str
    game_type: str  # type of the game, see supported_types to be in focus.
    interface_name_list: list[str] = list()  # interfaces that will be printed in file.
    lang: str  # programming language of the file to print.
    while True:
        game_name_input = __input_from_user__('Enter game name:')
        break
    while True:
        game_type_input = __input_from_user__(f'Enter game type, one of {supported_game_types} values;')
        if game_type_input in supported_game_types:
            game_type = game_type_input
            break
        else:
            print('Wrong value, type does not supported, try again.')
            continue
    while True:
        print('Enter "exit" - to break this loop or no interfaces;')  # special case of input from user, can be "exit" value.
        interface_name_input = __input_from_user__('Enter interface name:')
        if interface_name_input == 'exit':
            break
        elif interface_name_input != 'exit' and interface_name_input in interfaces_names_list:
            interface_name_list.append(interface_name_input)
            continue
        elif interface_name_input != 'exit' and interface_name_input not in interfaces_names_list:
            print('Wrong interface name, try again.')
            continue
    while True:
        language = __input_from_user__('Enter programming language:')
        if language in supported_languages:
            lang = language
            break
        else:
            print(f'Language does not support, try again - lang "{language}" is not in {supported_languages}.')

    code_gen(
        game_name=game_name_input,
        game_type=game_type,
        print_class=lang,
        interfaces=interface_name_list
    )
