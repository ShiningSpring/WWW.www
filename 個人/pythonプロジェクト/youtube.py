from yt_dlp import YoutubeDL

ydl_video_opts = {
    'outtmpl': 'C:\音楽\%(title)s'+'.mp3',
    'format': 'bestaudio'
    
}

with YoutubeDL(ydl_video_opts) as ydl:
    result = ydl.download([
      
        'https://www.youtube.com/watch?v=ERqqU72lYmI'
    ])