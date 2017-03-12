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

import com.codesod.example.designpattern.command.receiver.FanController;
import com.codesod.example.designpattern.command.receiver.LightController;

import org.junit.Test;

public class SingleButtonRemoteTest {

  @Test
  public void test() {
    SingleButtonRemote remote = new SingleButtonRemote();
    LightController lightController = new LightController();
    FanController fanController = new FanController();
    Command lightOnCommand = new LightOnCommand(lightController);
    Command lightOffCommand = new LightOffCommand(lightController);
    Command fanOnCommand = new FanOnCommand(fanController);
    Command fanOffCommand = new FanOffCommand(fanController);

    remote.setOnCommand(lightOnCommand);
    remote.setOffCommand(lightOffCommand);

    remote.onButtonPressed();
    remote.offButtonPressed();

    remote.setOnCommand(fanOnCommand);
    remote.setOffCommand(fanOffCommand);

    remote.onButtonPressed();
    remote.offButtonPressed();
  }
}