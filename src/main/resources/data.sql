INSERT INTO `task_type` VALUES 
(1,'緊急','最優先で取り掛かるべきタスク'),
(2,'重要','期限に間に合わせるべきタスク'),
(3,'できれば','今後やってみたいアイデア');

INSERT INTO `task` VALUES 
(NULL,1,1,'JUnitを学習','テストの仕方を学習する','2020-07-07 15:00:00'),
(NULL,1,3,'サービスの自作','マイクロサービスを作ってみる','2020-09-13 17:00:00');

INSERT INTO `user_info` VALUES (NULL, 'sample','sample@sample.com','$2a$10$oeobcca8HLATCWQ4TjCwOuOYpKHFfOFCmosvIAWhTdV4fmCyf8WoW',1,'ROLE_USER');
