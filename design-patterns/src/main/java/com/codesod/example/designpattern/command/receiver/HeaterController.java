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
package com.codesod.example.designpattern.command.receiver;

import static com.codesod.example.designpattern.command.receiver.HeaterController.Level.HIGH;
import static com.codesod.example.designpattern.command.receiver.HeaterController.Level.LOW;
import static com.codesod.example.designpattern.command.receiver.HeaterController.Level.MEDIUM;
import static com.codesod.example.designpattern.command.receiver.HeaterController.Level.OFF;

import lombok.Getter;

public class HeaterController {
  @Getter
  private Level currentLevel = OFF;

  public void high() {
    System.out.println("High");
    currentLevel = HIGH;
  }

  public void medium() {
    System.out.println("Medium");
    currentLevel = MEDIUM;
  }

  public void low() {
    System.out.println("Low");
    currentLevel = LOW;
  }

  public void off() {
    System.out.println("Off");
    currentLevel = OFF;
  }

  public enum Level {
    HIGH, MEDIUM, LOW, OFF
  }
}
