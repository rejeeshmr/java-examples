/*
 * Copyright 2017 MD Sayem Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codesod.example.designpattern.command;

import java.util.Arrays;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;

class MacroCommand implements Command {
  private Command[] commands;
  private Command[] reverseCommands;

  MacroCommand(Command... commands) {
    this.commands = commands;
    this.reverseCommands = Arrays.copyOf(commands, commands.length);
    ArrayUtils.reverse(reverseCommands);
  }

  @Override
  public void execute() {
    Stream.of(commands)
        .forEach(Command::execute);
  }

  @Override
  public void undo() {
    Stream.of(reverseCommands)
        .forEach(Command::undo);
  }
}
