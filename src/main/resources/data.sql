-- USERS INSERT
INSERT INTO USERS (id, username, password, email, created_at) 
VALUES 
    (RANDOM_UUID(), 'john_doe', 'password123', 'john.doe@example.com', NOW()),
    (RANDOM_UUID(), 'jane_smith', 'password456', 'jane.smith@example.com', NOW()),
    (RANDOM_UUID(), 'alice_jones', 'password789', 'alice.jones@example.com', NOW());

-- ACCOUNT INSERT (Bağlı UUID Kullanımı)
INSERT INTO ACCOUNT (id, user_id, balance, created_at) 
VALUES 
    (RANDOM_UUID(), (SELECT id FROM USERS WHERE username = 'john_doe'), 1000.00, '2023-01-01 10:00:00'),
    (RANDOM_UUID(), (SELECT id FROM USERS WHERE username = 'john_doe'), 1500.00, '2023-01-02 11:00:00'),
    (RANDOM_UUID(), (SELECT id FROM USERS WHERE username = 'jane_smith'), 2500.00, '2023-01-04 13:00:00'),
    (RANDOM_UUID(), (SELECT id FROM USERS WHERE username = 'alice_jones'), 4000.00, '2023-01-07 16:00:00');

-- TRANSACTION INSERT (Bağlı UUID Kullanımı)
INSERT INTO TRANSACTION (from_id, to_id, amount, transaction_date, status) 
VALUES 
    (
        (SELECT id FROM ACCOUNT WHERE balance = 1000.00), 
        (SELECT id FROM ACCOUNT WHERE balance = 1500.00), 
        100.00, 
        '2023-01-11 10:00:00', 
        'SUCCESS'
    ),
    (
        (SELECT id FROM ACCOUNT WHERE balance = 2500.00), 
        (SELECT id FROM ACCOUNT WHERE balance = 4000.00), 
        200.00, 
        '2023-01-12 11:00:00', 
        'FAILED'
    );