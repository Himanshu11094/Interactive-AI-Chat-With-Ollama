<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ChatGPT Prototype</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/custom.css"> <!-- Optional custom styles -->
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">ChatGPT Prototype</h2>
    <div class="card">
        <div class="card-body">
            <!-- Chat Messages -->
            <div id="chatBox" class="mb-3" style="height: 300px; overflow-y: auto; border: 1px solid #ccc; padding: 10px; background: #f9f9f9;">
                <!-- Dynamic chat messages will appear here -->
            </div>

            <!-- Input and Button -->
            <div class="input-group">
                <input type="text" id="userInput" class="form-control" placeholder="Type your message here...">
                <button id="sendButton" class="btn btn-primary">Send</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery for AJAX -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function () {
        const chatBox = $('#chatBox');
        const userInput = $('#userInput');
        const sendButton = $('#sendButton');

        // Handle the "Send" button click
        sendButton.click(function () {
            const userMessage = userInput.val().trim();

            if (userMessage !== '') {
                // Append user's message to the chat box
                chatBox.append('<div class="text-end mb-2"><span class="badge bg-primary">' + userMessage + '</span></div>');

                // Clear input
                userInput.val('');

                // Send AJAX request to the backend
                $.ajax({
                    url: '/chat', // Backend endpoint
                    method: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({ message: userMessage }),
                    success: function (response) {
                        // Append the response to the chat box
                        chatBox.append('<div class="text-start mb-2"><span class="badge bg-secondary">' + response.reply + '</span></div>');

                        // Scroll to the bottom of the chat box
                        chatBox.scrollTop(chatBox.prop("scrollHeight"));
                    },
                    error: function () {
                        // Handle errors
                        chatBox.append('<div class="text-start mb-2"><span class="badge bg-danger">Error: Unable to fetch response</span></div>');
                    }
                });
            }
        });

        // Allow sending message with "Enter" key
        userInput.keypress(function (e) {
            if (e.which === 13) { // Enter key
                sendButton.click();
            }
        });
    });
</script>
</body>
</html>
