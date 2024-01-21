print("Hello World!!")

import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

# Set your email credentials
sender_email = 'reaperhawk48@gmail.com'
sender_password = 'hgen ydba rbbc upmp'

# Recipient email address
recipient_email = 'ayesheesinha91@gmail.com'

# Create the email message
subject = 'Hello from Python!'
body = 'This is a test email sent from Python.'
message = MIMEMultipart()
message['From'] = sender_email
message['To'] = recipient_email
message['Subject'] = subject
message.attach(MIMEText(body, 'plain'))

# Set up the SMTP server
smtp_server = 'smtp.gmail.com'
smtp_port = 587

# Start the SMTP session
with smtplib.SMTP(smtp_server, smtp_port) as server:
    # Identify yourself to the SMTP server
    server.starttls()

    # Login to your email account
    server.login(sender_email, sender_password)

    # Send the email
    server.sendmail(sender_email, recipient_email, message.as_string())

print('Email sent successfully!')
