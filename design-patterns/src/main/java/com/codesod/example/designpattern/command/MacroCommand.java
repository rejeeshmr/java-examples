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

import java.util.stream.Stream;

class MacroCommand implements Command {
  private Command[] commands;

  MacroCommand(Command... commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    Stream.of(commands)
        .forEach(Command::execute);
  }

  @Override
  public void undo() {
    for (int i = commands.length - 1; i >= 0; i--) {
      commands[i].undo();
    }
  }
}
