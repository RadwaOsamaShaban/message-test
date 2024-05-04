# message-test

## Description
This project is a simple example  how to create schema and draw chart.

## Table of Contents
1. [Installation](#installation)
2. [Usage](#usage)
3. [Contributing](#contributing)

## Installation
To install the project, follow these steps:
1. Clone the repository: `https://github.com/RadwaOsamaShaban/message-test.git`
2. Install dependencies:  install mysql DB

## Usage
To use the project, follow these steps:
1. Open the project in your favorite code editor.
2. Run the project: `click restart` in editor

## Contributing
Contributions are welcome! To contribute to the project, follow these steps:
1.run this scripts in Db to draw chart
## participant table
INSERT INTO `message`.`participant` (`id`, `email`, `mobile`, `name`) VALUES ('1', 'radwa@osama.com', '01023882016', 'radwa');
INSERT INTO `message`.`participant` (`id`, `email`, `mobile`, `name`) VALUES ('2', 'ahmed@osama010.com', '01142036014', 'ahmed');

## conversation table 
INSERT INTO `message`.`conversation` (`id`, `create_at`, `last_update`, `title`) VALUES ('1', '2024-05-04 00:00:00', '2024-05-04 00:00:00', 'a');

## message table
INSERT INTO `message`.`message` (`create_at`, `message_text`, `participant_id`) VALUES ('2024-05-04 00:00:00', 'hello', '1');
INSERT INTO `message`.`message` (`create_at`, `message_text`, `participant_id`) VALUES ('2024-05-04 00:00:00', 'how are you', '1');
INSERT INTO `message`.`message` (`create_at`, `message_text`, `participant_id`) VALUES ('2024-05-04 00:00:00', 'fine', '2');
INSERT INTO `message`.`message` (`create_at`, `message_text`, `participant_id`) VALUES ('2024-05-01 00:00:00', 'can we start', '2');

